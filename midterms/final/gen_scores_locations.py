import random

locations = ['Chicago', 'Phoenix', 'NYC', 'LA', 'Nashville', 'Portland', 'Atlanta']
# scores are between 0 and 30
means = [5.0, 11.423, 7.453, 13.42, 15.222, 3.1919, 17.23087]
stdevs = [12.042, 4.2342, 6.9812, 7.2332, 1.42011, 2.5555, 4.905]

for _ in xrange(407):
    r = random.randint(0, 6)
    location = locations[r]
    score = min(30, max(0, random.normalvariate(means[r], stdevs[r])))
    print location, '\t', score
