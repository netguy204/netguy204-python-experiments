import tornado.httpserver
import tornado.ioloop
import tornado.web
import tornado.escape
import os

class MainHandler(tornado.web.RequestHandler):
  def get(self):
    results = []
    with os.popen('git log --pretty=oneline') as f:
      for line in f:
        words = line.split(' ')
        results.append({ 'sha1' : words[0], 'log' : ' '.join(words[1:]).rstrip() } )
        self.set_header("Content-Type", "text/javascript")

    json = tornado.escape.json_encode(results)

    callback = self.get_argument("callback", default=0)
    if callback:
      json = "%s(%s);" % (callback, json)

    self.write(json)

settings = {
    "static_path": os.path.join(os.path.dirname(__file__), "static")
}

application = tornado.web.Application([
    (r"/", MainHandler),
], **settings)

if __name__ == "__main__":
  http_server = tornado.httpserver.HTTPServer(application)
  http_server.listen(8000)
  tornado.ioloop.IOLoop.instance().start()
