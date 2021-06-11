# doit
将本地文件上传到github

将本地文件上传到GitHub步骤：

1、建立本地仓库：

执行：git init

打开git bash，切换到需要上传文件的目录下，执行上面的命令，就将该目录变成了本地仓库

2、将本地工作区项目添加到暂存区

执行：git add .

说明：git add .   将目录下所有的文件都放到了暂存区

git add readme.txt    将文件readme.txt放到了暂存区

3、将暂存区的文件提交到本地仓库

执行：git commit -m "readme.txt"

说明："" 中写入说明性文字，对提交的文件做说明，方便自己和其他人明白此次提交的作用

4、在github上创建自己的仓库（repository）

5、将本地仓库关联到GitHub仓库上

执行：git remote add origin https://github.com/xuanfeng27/doit

后面的url：https://github.com/xuanfeng27/doit 就是需要关联的GitHub仓库名称，在GitHub上点击对应的仓库，可以获取对应的url

6、将GitHub仓库更新到本地

执行：git pull origin master
git pull origin master --allow-unrelated-histories

说明：因为可能GitHub仓库上可能有些变更，需要先同步到本地，才能将本地的改变提交到GitHub仓库上

7、将本地仓库同步到GitHub仓库

执行：git push origin master


Git报错解决：OpenSSL SSL_read: Connection was reset, errno 10054 错误解决
git config --global http.sslVerify "false"


问题：fatal: Unable to create 'D:/data/.git/index.lock': File exists.

解决：执行：rm -f ./.git/index.lock  或  rm -Force ./.git/index.lock


git rm -r  --cached D:\zll\develop-tools\JetBrains\IdeaProjects\doitedu\.idea
git commit -m "移除"
git push
