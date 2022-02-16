import pytest


@pytest.fixture
def fixture():
    a = list(range(11))
    return a
