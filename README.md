## Java-Jiyu-Killer

### 1.介绍

一个我无聊时写的[Python-Nanruan-Killer](https://github.com/zhouxuanyi-zxy/Python-Nanruan-Killer)的java版

其仍然使用pskill和ntsd及taskkill杀极域进程

+ 支持最小化极域屏幕广播

+ 支持缺少文件自动下载

##### 至于为什么用Java?

因为好用,而且好打包成.exe文件

### 2.各版本的功能差异

| 版本/特性                                                    | 杀死极域进程 | 检测所需文件是否存在 | 自动下载所需文件 | 自释放所需文件(base64) | 最小化屏幕广播   | 通过删除文件使极域停止运行 | <--的基础--自动从注册表读取极域程序地址 |
| ------------------------------------------------------------ | ------------ | -------------------- | ---------------- | ---------------------- | ---------------- |---------------| --------------------------------------- |
| [Python-Nanruan-Killer](https://github.com/zhouxuanyi-zxy/Python-Nanruan-Killer) | ✔            | ✔                    | ✔                | ✔                      | ✔ (大部分情况下) | ✔             | ✔                                       |
| [Cpp-Nanruan-Killer](https://github.com/zhouxuanyi-zxy/Cpp-Nanruan-Killer) | ✔            | ×                    | ×                | ×                      | ×                | ×             | ×                                       |
| [CSharp-Jiyu-Killer](https://github.com/zhouxuanyi-zxy/CSharp-Jiyu-Killer) | ✔            | ✔                    | ×                | ×                      | ×                | ×             | ×                                       |
| [Java-Jiyu-Killer](https://github.com/zhouxuanyi-zxy/Java-Jiyu-Killer) | ✔            | ✔                    | ✔                | TODO                   | ✔ (未完全完成 )  | TODO (快了)     | TODO                                    |

** ✔ 为已经支持

** × 为不支持(甚至以后可能也不会)

** TODO 为有计划

所以 Jiyu-Killer (Nanruan-Killer) 系列都是以python版本为基准的

其它版本的功能差异还请谅解



### 3.版本更新历史

#### v1.01 (2024.5.2)

1.自动检测所需文件

2.自动下载所需文件

3.支持最小化极域屏幕广播窗口(不过还未完工)

4.杀极域进程

