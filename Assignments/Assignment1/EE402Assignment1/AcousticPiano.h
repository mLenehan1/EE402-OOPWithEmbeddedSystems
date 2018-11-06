/*
 * AcousticPiano.h
 *
 *  Created on: 30 Oct 2018
 *      Author: mlenehan
 */

#ifndef ACOUSTICPIANO_H_
#define ACOUSTICPIANO_H_

#include <iostream>
#include "Piano.h"

using std::string;

class AcousticPiano: public Piano {
private:
public:
	string pianoShape;
	AcousticPiano(int, string, float, int, string);
	AcousticPiano(string, float, int, string);
	AcousticPiano(const AcousticPiano&);
	void display();
	virtual ~AcousticPiano();
};

#endif /* ACOUSTICPIANO_H_ */
