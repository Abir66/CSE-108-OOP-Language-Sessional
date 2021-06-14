#include <iostream>
#include <cmath>

using namespace std;

class Point
{
    // x and y coordinate
    int x, y;

public:
    //Add necessary constructor(s) to initialize x and y
    Point()
    {
        x = 0;
        y = 0;
    }

    Point(int a, int b)
    {
        set(a, b);
    }

    //Add your set and get functions for x and y
    void set(int a, int b)
    {
        x = a;
        y = b;
    }

    int getx()
    {
        return x;
    }

    int gety()
    {
        return y;
    }

    //output
    void print()
    {
        cout << "Coordinate: " << x << ", " << y << endl;
    }
};

class Circle
{
    Point p;
    int radius;

public:
    // Add necessary constructor(s) to initialize p and radius
    Circle(int x, int y, int r)
    {
        p.set(x, y);
        radius = r;
    }

    // Overload “upload” functions
    void update(int a)
    {
        radius += a;
    }

    void update(int a, int b)
    {
        p.set(p.getx() + a, p.gety() + b);
    }

    void update(int a, int b, int c)
    {
        p.set(p.getx() + a, p.gety() + b);
        radius += c;
    }

    //output
    void print()
    {
        cout << "Center ";
        p.print();
        cout << "Radius: " << radius << endl;
    }
};

class Line
{

    Point p1, p2;

public:
    Line(int a1, int b1, int a2, int b2)
    {
        p1.set(a1, b1);
        p2.set(a2, b2);
    }

    void printLength()
    {
        cout << "Length: ";
        int x = p1.getx() - p2.getx(), y = p1.gety() - p2.gety();
        cout << sqrt(x * x + y * y) << endl;
    }
};

int main()
{

    Point p(5, 5);
    Circle c(2, 3, 5);
    cout << endl << "Point Display" << endl;
    p.print();
    cout << endl << "Circle Display" << endl;
    c.print();
    cout << endl;

    //First update
    cout << "First Update" << endl;

    // call “update” function of Circle class to increase the center’s x coordinate by 5 and y coordinate by 5;
    c.update(5, 5);
    c.print();
    cout << endl;

    //Second update
    cout << "Second Update" << endl;

    // call “update” function of Circle class to increase the radius by 6;
    c.update(6);
    c.print();
    cout << endl;

    //Third update
    cout << "Third Update" << endl;

    // call “update” function of Circle class to increase the center’s x coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update(2, 2, 2);
    c.print();
    cout << endl;

    //Line
    cout << "Line Display" << endl;
    Line l(1, 1, 2, 2);
    l.printLength();
    cout << endl;

    return 0;
}