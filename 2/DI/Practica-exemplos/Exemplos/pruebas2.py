import unittest

def cadrado(numero):
    return numero**2

class ExemploProbas (unittest.TestCase):
    def test(self):
        l = [0, 2, 5, 100]
        r = [cadrado(n) for n in l]
        self.assertEqual(r, [0, 4, 25, 10000])
        # pass # dice que pasa el test
        # raise AssertionError() # levanta error

if __name__ == "__main__":
    unittest.main()