#include <iostream>
#include <cstdlib>

using namespace std;

class Matrix
{
    int *mat = NULL, row, col;

public:
    Matrix(int r, int c);
    void print();
    void set(int r, int c, int value);
    int get(int r, int c);
    void add(int n);
    int add();
    ~Matrix();
};

Matrix::Matrix(int r, int c)
{
    row = r, col = c;
    mat = (int *)malloc(row * col * sizeof(int));
}

Matrix::~Matrix()
{
    free(mat);
}

void Matrix::print()
{
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            cout << *(mat + i * col + j) << " ";
        }
        cout << endl;
    }
}

void Matrix::set(int r, int c, int value)
{
    *(mat + r * col + c) = value;
}

int Matrix::get(int r, int c)
{
    return *(mat + r * col + c);
}

void Matrix::add(int n)
{

    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            *(mat + i * col + j) += n;
        }
    }
}

int Matrix::add()
{

    int sum = 0;
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            sum += *(mat + i * col + j);
        }
    }
    return sum;
}

int main()
{

    cout << "Hello World" << '\n';
    Matrix m(3, 3);
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            m.set(i, j, i + j);

    m.print();
    cout << m.get(0, 0) << '\n';
    m.set(0, 0, 100);
    cout << m.get(0, 0) << '\n';
    m.add(100);
    m.print();
    cout << m.add() << '\n';

    return 0;
}