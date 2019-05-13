/*
 * A.cpp
 *
 *  Created on: 6 Jan 2019
 *      Author: mlenehan
 */

#include "A.h"

int main(){
	A* a = new A();
	AA* aa = new AA();
	a->display();
	a = aa;
	aa = static_cast<AA*>(a);
	a-> display();
	aa->display();
	return 0;
}

