import  random
print(random.random())
print(random.uniform(8,20))
deck = "ace two three four".split()
print(deck)
print(random.choice(['win', 'lose', 'draw']))
print(random.choices(['red', 'black', 'green'], [18, 18, 100], k=8))
