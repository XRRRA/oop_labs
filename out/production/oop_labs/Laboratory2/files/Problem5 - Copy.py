import turtle


# Draw a triangle function
def triangle(coords, t, color):
    # first the turtle goes to its position.
    # we raise the pen, so it won't draw while it goes to its position
    t.fillcolor(color)
    t.up()
    t.goto(coords[0][0], coords[0][1])
    # Put the pen down, so we can draw
    t.down()
    # Draw the triangle itself
    t.begin_fill()
    t.goto(coords[1][0], coords[1][1])
    t.goto(coords[2][0], coords[2][1])
    t.goto(coords[0][0], coords[0][1])
    t.end_fill()


def middle(p1, p2):
    # The middle of a side is the sum of the coordinates divided by 2
    return (p1[0]+p2[0]) / 2, (p1[1]+p2[1]) / 2


def sierpinski(points, repetitions, my_turtle, i):
    # Draw the triangle function
    color = ['red', 'light blue', 'yellow', 'orange', 'lime', 'turquoise', 'purple', 'pink', 'blue']
    triangle(points, my_turtle, color[i])
    i += 1
    if i == 9:
        i = 0
    if repetitions > 0:
        # Recall the function using the point x, to find the middle of the sides it unites,
        # with 1 less repetition and the same turtle
        # Recall three time as we have 3 points for a triangle
        sierpinski([points[0], middle(points[0], points[1]), middle(points[0], points[2])], repetitions-1, my_turtle, i)
        sierpinski([points[1], middle(points[0], points[1]), middle(points[1], points[2])], repetitions-1, my_turtle, i)
        sierpinski([points[2], middle(points[2], points[1]), middle(points[0], points[2])], repetitions-1, my_turtle, i)


i = 0
screen = turtle.Screen()
drawing = turtle.Turtle()
turtle.screensize(canvwidth=900, canvheight=900)
drawing.speed(10)
# setting some coordinates of the peak points of the biggest triangle
point = [[-400, -200], [0, 400], [400, -200]]
# The n depth of the triangle
n = int(input())
sierpinski(point, n, drawing, i)
screen.exitonclick()
