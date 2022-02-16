import pytest


def test_add():
    n1 = 50
    n2 = 50

    assert n1 + n2 == 100


def test_substract():
    n1 = 30
    n2 = 20

    assert n1 - n2 == 10


def test_multiply():
    n1 = 10
    n2 = 10

    assert n1 * n2 == 100


def test_division():
    n1 = 50
    n2 = 10

    assert n1 / n2 == 10
