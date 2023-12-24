// section.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <bits/stdc++.h>
using namespace std;
int a[100000], b[100000], c, d;

struct section
{
	int a;
	int b;
};

bool cmp(section one, section two)
{
	return one.a < two.a;
}
section info[100000];

int main()
{
	
	int n;
	cin >> n >> c >> d;
	for (int index = 0; index < n; index++)
	{
		
		cin >> info[index].a >> info[index].b;
	}
	
	sort(info,info + n, cmp);

	int bmax = 0;
	int i = 0;
	int answer = 0;
	
	while (c<d)
	{
		
		while (info[i].a <= c && i < n)
		{
			bmax = max(bmax, info[i].b);
			i++;
		}
		answer++;
		c = bmax;

		
	}
    cout << answer;

	
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
