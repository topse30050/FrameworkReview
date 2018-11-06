package topse.pattern.topse30050.tools;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.apache.commons.io.IOUtils;
import topse.pattern.topse30050.framework.FileViewStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JSONViewer implements FileViewStrategy {
    @Override
    public void show(InputStream input) {
        try {
            showJSON(Json.parse(IOUtils.toString(input, StandardCharsets.UTF_8)).asObject());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* これ以降、課題提示JSONViewerからコピペ */
    private static int indent = 0;  //表示する時のインデントレベル
    private static boolean nameOut = false; //名前出力後に余分なスペースを出さないようにするためのフラグ変数

    //JSONの内容をダンプする。再帰呼び出しにより、データの形式に寄らずに出力可能
    private static void showJSON(JsonValue obj) {
        if (!nameOut) {
            indentSpace(); //必要ならインデント出力
        }
        if (obj.isObject()) {   //引数がオブジェクトの場合
            System.out.println("{");
            nameOut = false;
            for (JsonObject.Member o : obj.asObject()) {    //オブジェクトの各要素について
                indent++;
                String name = o.getName();  //名前を取得
                JsonValue value = o.getValue(); //値を取得
                indentSpace();
                System.out.print(name + ": ");
                nameOut = true;
                showJSON(value);    //値に関して再帰呼び出しする
                nameOut = false;
                indent--;
            }
            indentSpace();
            System.out.println("}");
        } else if (obj.isArray()) {   //配列のの各要素について
            System.out.println("[");
            nameOut = false;
            for (JsonValue value : obj.asArray()) {  //配列の各要素について
                indent++;
                showJSON(value); //要素に関して再帰呼び出しする
                indent--;
            }
            indentSpace();
            System.out.println("]");
        } else if (obj.isNull()) {
            System.out.println("NULL");
        } else if (obj.isBoolean()) {
            System.out.println(obj.asBoolean());
        } else if (obj.isNumber()) {
            System.out.println(obj.asFloat());  //整数か小数かは判断が難しいため、とりあえず一律にfloatにする
        } else if (obj.isString()) {
            System.out.println(obj.asString());
        }
    }

    //JSON出力時のインデント出力
    private static void indentSpace() {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
    }
}
