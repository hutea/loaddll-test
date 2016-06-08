作者[@秀才遇到猫][1]

### 目录结构[maven标准目录结构][2]
+ [main目录](src/main)
 + [org/smirkcat/plateocr](src/main/java/org/smirkcat/plateocr) tesseract 识别和工具函数目录，使用请参考里面函数
 + [dll](src/main/resources/dll) 放置动态库目录，打成jar包时，会自己解压其中的动态库至系统的temp文件夹
+ [test目录](src/test)
 + [org/smirkcat/plateocr](src/test/java/org/smirkcat/plateocr) 测试函数类，测试时请运行Test.java即可
 + [tessdata](src/test/resources/tessdata) tesseract 识别所需的一些配置文件，以jar包方式使用时**请把tessdata整个文件夹请放到对应的classpath环境下**，目前没提供jar包读取
 + [测试图片](src/test/resources/jpg) 测试图片目录
 + [测试结果](src/test/resources/test-result.txt) 放置测试图片的输出结果
 
### 一些说明
* 本项目是使用opencv-mser提取身份证后妈图块，使用loaddll加载Mser动态库，只提供windows环境
* 然后使用javacpp提供好的org.bytedeco.javacpp-presets下的tesseract识别身份证号码

### 结果比对
#### 图片test.jpg-432522199501235621
![测试图片](src/test/resources/jpg/test.jpg)

| 是否预处理(MSER)     | 识别最后一行           | 后18位  |
| :------------------: |:----------------------:|: ------:|
| 否     |4271533432522199501235621 | 432522199501235621 |
| 是     |311423921432522199501235621|   432522199501235621 |

#### 图片test1.jpg-11204416541220243X
![测试图片](src/test/resources/jpg/test1.jpg)

| 是否预处理(MSER)     | 识别最后一行           | 后18位  |
| :------------------: |:----------------------:|: ------:|
| 否     |501142811165112282433 | 142811165112282433 |
| 是     |2233583353112044165412202438|  112044165412202438 |

[1]: http://weibo.org/smirklijie
[2]: http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html