import httplib
from BeautifulSoup import *

SERVER = "www.crummy.com"
PAGE = "/software/BeautifulSoup/documentation.html"

conn = httplib.HTTPConnection(SERVER)
conn.request("GET", PAGE)
resp = conn.getresponse()

if resp.status == 200:
  soup = BeautifulSoup(resp)
  h1s = soup.findAll('h1')
  print "H1 's"
  for h1 in h1s:
    print h1.contents

  h2s = soup.findAll('h2')
  print "H2 's"
  for h2 in h2s:
    print h.contents


