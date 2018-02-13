package com.jiancai.algorithm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AONEExplore {

  public static final String logs = "type=SYSCALL msg=audit(1434371271.277:135496) arch=c000003e syscall=2 success=yes exit=3 a0=7fff0054e929 a1=0 a2=1fffffffffff0000 a3=7fff0054c390 items=1 ppid=6265 pid=6266 auid=1000 uid=0 gid=0 euid=0 suid=0 fsuid=0 egid=0 sgid=0 fsgid=0 tty=pts0 ses=113 comm=\"cat\" exe=\"/usr/bin/cat\" key=\"ssh config change\"";


  public static int encrypt(int value) {
    ByteBuffer b = ByteBuffer.allocate(4);
    b.putInt(value);
    byte[] bytes = b.array();
    // 0, 1, 2, 3, 4, 6
    byte[] newInt = new byte[4];
    for (int i = 0; i < bytes.length / 2; i++) {
      newInt[i] = bytes[bytes.length - i - 1];
      newInt[bytes.length - i - 1] = bytes[i];
    }
    return ByteBuffer.wrap(newInt).getInt();
  }

  public static Map<String, Object> format(String logs) {
    Map<String, Object> logMap = new HashMap<String, Object>();
    List<String> keys = new ArrayList<String>();
    List<String> values = new ArrayList<String>();
    findTokenList(keys, values, "", 0);
    for (int i = 0; i < keys.size(); i++) {
      logMap.put(keys.get(i), values.get(i));
    }
    return logMap;
  }

  private static void findTokenList(List<String> keys, List<String> values, String token, int i) {
    if (i >= logs.length()) {
      values.add(token);
      return;
    } else if (logs.toCharArray()[i] == 32) {
      if (token.lastIndexOf("\"") != 0) {
        values.add(token);
        findTokenList(keys, values, "", i + 1);
      } else {
        findTokenList(keys, values, token + logs.toCharArray()[i], i + 1);
      }
    } else if (logs.toCharArray()[i] == '=') {
      keys.add(token);
      findTokenList(keys, values, "", i + 1);
    } else {
      findTokenList(keys, values, token + logs.toCharArray()[i], i + 1);
    }
  }

  public static void main(String[] args) {
    //Test1
    System.out.println(encrypt(167772160));
    //Test2
    System.out.println(format(logs));
  }
}
