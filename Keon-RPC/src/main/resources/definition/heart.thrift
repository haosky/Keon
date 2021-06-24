namespace java haooho.com.keon.rpc
namespace py haooho.com.keon.rpc

struct beat {
  1: i32 type
  2: string msg
}

service ping {
  void ping()

  beat toBeat()
}