下载leetcode插件后，需要修改以下几个参数就可以享受丝滑刷提了。

1.
====codeFileName内容====

$!velocityTool.camelCaseName(${question.titleSlug})

====codeFileName内容====

2.
====codeTemplate内容====

// [${question.frontendQuestionId}] ${question.title}
${question.content}

package com.tiger.leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug}) {
	public static void main(String[] args) {
		Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
	}

    ${question.code}
}

====codeTemplate内容====

3.tempFilePath:

${目录路径}/myleetcode/src/main/java/com/tiger

对了，最后根据自己偏好勾选一些配置即可，enjoy it



