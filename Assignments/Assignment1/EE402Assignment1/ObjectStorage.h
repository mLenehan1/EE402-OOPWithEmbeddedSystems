/*
 * ObjectStorage.h
 *
 *  Created on: 1 Nov 2018
 *      Author: mlenehan
 */

#ifndef OBJECTSTORAGE_H_
#define OBJECTSTORAGE_H_

#include <iostream>

using std::string;

template<class T, int storeSize>
class ObjectStorage {
	T array[storeSize];
public:
	T getMaxOfTwo(int i, int j){
		T outVal = array[i]>array[j]? array[i]:array[j];
		return outVal;}
};

#endif /* OBJECTSTORAGE_H_ */
