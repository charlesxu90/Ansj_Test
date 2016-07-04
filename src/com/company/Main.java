package com.company;
import org.ansj.domain.Term;
import org.ansj.library.UserDefineLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.library.Library;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //String[][] text = new String[3][1];
        //text[0][0] = "皮鞋（leather shoe）是指以天然皮革为鞋面，以皮革或橡胶、塑料、PU发泡、PVC等为鞋底，经缝绱、胶粘或注塑等工艺加工成型的鞋类。";
        //text[1][0] = "皮鞋透气、吸湿，具有良好的卫生性能，是各类鞋靴中品位最高的鞋。";
        //text[2][0] = "几千年前，人类的祖先就有了穿鞋的习惯，用兽皮裹足、从皮造履到现代皮鞋，皮鞋的历史相当悠久。";
        String str = "张三丰说:几千年前，人类的祖先就有了穿鞋的习惯，用兽皮裹足、从皮造履到现代皮鞋，皮鞋的历史相当悠久。";
        //int[] type = new int[]{1};
        //int[] num = new int[]{0};
        try {

            loadFromFile();
            //通过内存中reload
            // loadFromStr();
            //List<Term> result = ToAnalysis.parse(str);
            //for (Term istr : result) {
            //    System.out.println(istr.getName() + istr.getNatureStr() /* + istr.toString()*/);
            //}
            List paser = ToAnalysis.parse("csdn创新院是一个好公司") ;
            System.out.println(paser);
        }catch (Exception e) {
            System.out.println("exception catched");
        }
    }

    private static void loadFromStr() {
        // TODO Auto-generated method stub
        Forest forest = new Forest() ;
        Library.insertWord(forest, "中国  nature  1000") ;
        //将新构建的辞典树替换掉旧的。
        UserDefineLibrary.FOREST = forest ;
    }

    private static void loadFromFile() {
        // TODO Auto-generated method stub
        //make new forest
        Forest forest = new Forest() ;

        UserDefineLibrary.loadFile(forest, new File("library/userLibrary/userLibrary.dic")) ;

        //将新构建的辞典树替换掉舊的。
        UserDefineLibrary.FOREST = forest ;
    }

}
