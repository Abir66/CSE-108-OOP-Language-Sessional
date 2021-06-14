#include <iostream>
#include <cstring>

using namespace std;

namespace infrastructure
{

    class pool
    {
        int height, width, depth;
        char painted_color[10];

    public:
        void set_properties(int h, int w, int d, char *pc)
        {
            height = h;
            width = w;
            depth = d;
            strcpy(painted_color, pc);
        }
        void show()
        {
            // This function will show the dimention (height x width x depth), and the underlying painted_color information
            cout << height << " x " << width << " x " << depth << endl;
            cout << painted_color << endl;
        }
    };

}

namespace sports
{

    class pool
    {
        char table_ingredient[20];
        char table_color[10];

    public:
        void set_properties(char *ti, char *tc)
        {
            strcpy(table_ingredient, ti);
            strcpy(table_color, tc);
        }
        void show()
        {
            // This function will show the pool table ingredient and table color
            cout << "Table ingredient: " << table_ingredient << endl;
            cout << "Table color: " << table_color << endl;
        }
    };

}

int main()
{
    infrastructure::pool p1;
    sports ::pool p2;

    p1.set_properties(10, 20, 30, "Blue");
    p2.set_properties("Wood", "Red");

    p1.show();
    p2.show();

    return 0;
}