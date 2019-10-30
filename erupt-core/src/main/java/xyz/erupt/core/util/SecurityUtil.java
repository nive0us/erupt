package xyz.erupt.core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by liyuepeng on 2019-10-30.
 */
public class SecurityUtil {

    // xss跨站脚本检测
    public static boolean xssInspect(String value) {
        if (StringUtils.isNotBlank(value)) {
            // 避免script 标签
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免src形式的表达式
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 删除单个的 </script> 标签
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 删除单个的<script ...> 标签
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 eval(...) 形式表达式
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 e­xpression(...) 表达式
            scriptPattern = Pattern.compile("e­xpression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 javascript: 表达式
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 vbscript:表达式
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 onload= 表达式
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 onmouseover= 表达式
            scriptPattern = Pattern.compile("onmouseover(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 onfocus= 表达式
            scriptPattern = Pattern.compile("onfocus(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
            // 避免 onerror= 表达式
            scriptPattern = Pattern.compile("onerror(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            if (scriptPattern.matcher(value).matches()) {
                return true;
            }
        }
        return false;
    }
}
