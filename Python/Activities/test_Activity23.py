import pytest


def test_sum(fixture):
    sum = 0
    for x in fixture:
        sum = sum + x

    assert sum == 55