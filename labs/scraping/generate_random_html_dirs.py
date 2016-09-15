import random
import string
import os

HTML = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>another random page</title>
</head>
<body>
   {links}
</body>
</html>
"""

LINK = '<p><a href="http://sheng.io/fisk/labs/scraping/assignment/{url}">another page</a></p>'


def rs():
    N = 3
    return ''.join(random.choice(string.ascii_lowercase + string.digits) for _ in range(N))

def rn():
    return random.randint(2, 8)

def create_dir(d):
    os.makedir(d)


for j in range(10):
    pages = []
    for x in range(10):
        # make leaf index files
        dirs = []
        for y in xrange(rn()):
            d = '/'.join(rs() for i in xrange(rn()))
            os.makedirs(d)
            dirs.append(d)
            with open(d + '/index.html', 'w+') as f:
                f.write(HTML.format(links=''))
        d = '/'.join(rs() for i in xrange(rn()))
        os.makedirs(d)
        with open(d + '/index.html', 'w+') as f:
            f.write(HTML.format(links='\n'.join(LINK.format(url=l) for l in dirs)))
        pages.append(d)
    d = '/'.join(rs() for i in xrange(rn()))
    os.makedirs(d)
    with open(d + '/index.html', 'w+') as f:
        f.write(HTML.format(links='\n'.join(LINK.format(url=l) for l in pages)))
    print LINK.format(url=d)


