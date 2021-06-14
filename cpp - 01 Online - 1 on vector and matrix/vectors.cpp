#include <iostream>
#include <cstdlib>

using namespace std;



typedef struct
{
    int x, y, z;
} point;

class Vectors
{
    int size;
    point *ara;
    int vec[3];

public:
    Vectors(int n);
    void print();
    void set(int index, int x, int y, int z);
    int *get(int index);
    void add(int x, int y, int z);
    int *add();
    ~Vectors();
};

Vectors::Vectors(int n)
{
    size = n;
    ara = (point *)malloc(n * sizeof(point));
}

Vectors::~Vectors()
{
    free(ara);
}

void Vectors::print()
{

    for (int i = 0; i < size; i++)
    {
        cout << ara[i].x << " " << ara[i].y << " " << ara[i].z << endl;
    }
}

void Vectors::set(int index, int x, int y, int z)
{

    ara[index].x = x;
    ara[index].y = y;
    ara[index].z = z;
}

int *Vectors::get(int index)
{

    vec[0] = ara[index].x;
    vec[1] = ara[index].y;
    vec[2] = ara[index].z;

    return vec;
}

void Vectors::add(int x, int y, int z)
{

    for (int i = 0; i < size; i++)
    {
        ara[i].x += x;
        ara[i].y += y;
        ara[i].z += z;
    }
}

int *Vectors::add()
{
    vec[0] = 0, vec[1] = 0, vec[2] = 0;
    
    for (int i = 0; i < size; i++)
    {
        vec[0] += ara[i].x;
        vec[1] += ara[i].y;
        vec[2] += ara[i].z;
    }

    return vec;
}

int main()
{

    cout << "Hello World" << '\n';
    Vectors m(3);
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            m.set(i, i + j, i - j, i * j);
    m.print();
    int *array = m.get(0);
    cout << array[0] << ' ' << array[1] << ' ' << array[2] << '\n';
    m.set(0, 100, 100, 100);
    array = m.get(0);
    cout << array[0] << ' ' << array[1] << ' ' << array[2] << '\n';
    m.add(100, 100, 100);
    m.print();
    array = m.add();
    cout << array[0] << ' ' << array[1] << ' ' << array[2] << '\n';
    return 0;
}