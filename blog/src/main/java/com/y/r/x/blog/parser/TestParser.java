// package com.y.r.x.blog.parser;
//
// import com.vladsch.flexmark.ast.Node;
// import com.vladsch.flexmark.html.HtmlRenderer;
// import com.vladsch.flexmark.parser.Parser;
// import com.vladsch.flexmark.util.options.MutableDataSet;
//
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.nio.file.Path;
// import java.nio.file.Paths;
//
// /**
//  * Created by r.x on 2018/10/7.
//  */
// public class TestParser {
//     public static void main(String[] args) throws IOException {
//         MutableDataSet options = new MutableDataSet();
//
//         // uncomment to set optional extensions
//         //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));
//
//         // uncomment to convert soft-breaks to hard breaks
//         //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");
//
//         Parser parser = Parser.builder(options).build();
//         HtmlRenderer renderer = HtmlRenderer.builder(options).build();
//
//         // You can re-use parser and renderer instances
//         Node document = parser.parse("This is *Sparta*");
//         String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
//         System.out.println(html);
//         document = parser.parse("# title");
//         System.out.println(renderer.render(document));
//
//         Path path = Paths.get("e:", "software", "intelliJ IDEA/project/keeplearning", "README.md");
//         File file = path.toFile();
//         FileInputStream fileInputStream = new FileInputStream(file);
//         byte[] bytes = new byte[1024];
//         int count = 0;
//         StringBuilder content = new StringBuilder();
//         while ((count = fileInputStream.read(bytes)) > 0) {
//             content.append(new String(bytes));
//         };
//         System.out.println(content.toString());
//         document = parser.parse(content.toString());
//         System.out.println(renderer.render(document));
//     }
// }
