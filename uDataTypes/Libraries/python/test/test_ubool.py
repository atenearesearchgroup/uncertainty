import sys, os
sys.path.append(os.path.dirname(os.path.realpath(__file__)) + "/../")

import unittest

from uncertainty.utypes import *
from funcs_testing import *

class uboolTest(unittest.TestCase):

    def setUp(self):
        self.x = ubool(0.7)
        self.y = ubool(0.4)
        self.z = ubool(0.6)
        self.w = ubool(0.3)
        self.f = ubool(0.0)
        self.t = ubool(1.0)

    def test_init(self):
        t(ubool(0.7), ubool(0.7))
        t(ubool('0.7'), ubool(0.7))

        t(ubool(0), ubool(0.0))
        t(ubool('0'), ubool(0.0))

        t(ubool(1), ubool(1.0))
        t(ubool('1'), ubool(1.0))

        t(ubool(True), ubool(1.0))
        t(ubool('True'), ubool(1.0))

        t(ubool(False), ubool(0.0))
        t(ubool('False'), ubool(0.0))

    '''
        Operators
    '''
    def test_and(self):
        ''' AND '''
        ands(self.x, self.y, ubool(0.280))
        ands(self.x, self.z, ubool(0.420))
        
    def test_and_booleans(self):
        ''' AND Booleans'''
        ands(self.x, True,  ubool(0.700))
        ands(self.x, False, ubool(0.000))
        ands(True, self.x,  ubool(0.700))
        ands(False, self.x, ubool(0.000))

    def test_or(self):
        ''' OR '''
        ors(self.x, self.z, ubool(0.880))
        ors(self.x, self.y, ubool(0.820))
        
    def test_or_booleans(self):
        ''' OR Booleans '''
        ors(self.x, True, ubool(1.000))
        ors(self.x, False, ubool(0.700))
        ors(True, self.x, ubool(1.000))
        ors(False, self.x, ubool(0.700))

    def test_xor(self):
        ''' XOR '''
        xors(self.x, self.z, ubool(0.100))
        xors(self.x, self.y, ubool(0.300))

    def test_xor_booleans(self):
        ''' XOR Booleans '''
        xors(self.x, True,  ubool(0.300))
        xors(self.x, False, ubool(0.700))
        xors(True, self.x,  ubool(0.300))
        xors(False, self.x, ubool(0.700))

    def test_not(self):
        ''' NOT '''
        nots(self.w, ubool(0.700))
        nots(self.x, ubool(0.300))
        nots(self.t, ubool(0.000))
        nots(self.f, ubool(1.000))

    def test_implies(self):
        ''' Implies '''
        implies(self.w, self.x, ubool(0.910))
        implies(self.x, self.w, ubool(0.510))

    def test_equivalent(self):
        ''' Equivalent '''
        equivalent(self.x, self.w, ubool(0.600))
        equivalent(self.w, self.x, ubool(0.600))
        equivalent(self.w, self.w, ubool(1.000))
        equivalent(self.t, self.f, ubool(0.000))
        equivalent(self.f, self.t, ubool(0.000))
    
    def test_equals(self):
        ''' Equals '''
        equals(self.x, self.w, ubool(0.600))
        equals(self.w, self.y, ubool(0.900))
        equals(self.w, self.w, ubool(1.000))
        equals(self.t, self.f, ubool(0.000))
        equals(self.f, self.t, ubool(0.000))

    def test_distinct(self):
        ''' Distinct '''   
        distinct(self.w, self.y, ubool(0.100))
        distinct(self.x, self.w, ubool(0.400))
        distinct(self.w, self.x, ubool(0.400))
        distinct(self.t, self.f, ubool(1.000))
        distinct(self.f, self.t, ubool(1.000))


if __name__ == '__main__':
    unittest.main()
