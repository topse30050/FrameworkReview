package topse.pattern.topse30050;

public class FileViewClient {
    public static void main(String[] args) {
        for (String filePath : args) {
            System.out.println(filePath);

            FileViewContext context = new FileViewContext();

            if (filePath.toLowerCase().startsWith("http")) {
                context.setReader(new HttpGetter());
            } else {
                context.setReader(new LocalGetter());
            }

            if (filePath.toLowerCase().endsWith("csv")) {
                context.setViewer(new CSVViewer());
            } else if (filePath.toLowerCase().endsWith("json")) {
                context.setViewer(new JSONViewer());
            } else {
                System.exit(-1);
            }

            context.show(context.read(filePath));
        }
    }
}
