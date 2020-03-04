package Top100;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    // 0-9 each button contains diff letter
    private static String letterMap[] = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    // 思路:回溯法，具体过程：以“23”为例，首先从i=0开始，letters="abc",第0个字母为a，
    // 先判断当前路径的长度是否大于digits的长度，如果没有，则进行递归，i+,到按键“3”上来，
    //3最左边是d,加入路径
    //如果长度等于digits长度则将此路径所形成的字符串加入到最后结果中
    //回退到上一步，到按键3的第1个字母，e,同样因为长度达到了，此解加入到最后结果中
    //依次类推
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        //若不为空返回空，否则进行全排列
        if (!"".equals(digits)) {
            combine(new StringBuilder(), res, 0, digits);
        }
        return res;
    }

    public void combine(StringBuilder sb, List<String> res, int i, String digits) {
        //若此时字符串长度达到digit.length，直接将组成的字符串作为结果之一返回；
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //获取当前第i个按键
        char ch = digits.charAt(i);
        String letters = letterMap[ch - '0'];
        //each letter作为元素加入到组合中
        for (int k = 0; k < letters.length(); k++) {
            sb.append(letters.charAt(k));
            //依次递归i+1的按键，将字母分别进行组合
            combine(sb, res, i + 1, digits);
            //组合长度达到后，将组合作为结果之一，并且将临时存储字符串的stringbuilder清空存储下一种组合
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

