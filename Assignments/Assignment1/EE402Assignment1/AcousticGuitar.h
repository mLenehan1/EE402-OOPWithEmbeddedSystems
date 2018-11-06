/*
 * AcousticGuitar.h
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#ifndef ACOUSTICGUITAR_H_
#define ACOUSTICGUITAR_H_

#include <iostream>
#include "Guitar.h"

using std::string;

class AcousticGuitar: public virtual Guitar {
private:
protected:
public:
	int noOfSoundholes;
	AcousticGuitar(int, string, float, string, int, int);
	AcousticGuitar(string, float, string, int, int);
	void display();
	virtual ~AcousticGuitar();
};

#endif /* ACOUSTICGUITAR_H_ */
