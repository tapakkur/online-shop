//package com.qakmak.eshop.utils;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
///**
// * created by tapakkur on 2019/2/16
// */
//public class Swagger2Markdown {
//
//    Path outputFile = Paths.get("build/swagger");
//    Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//            .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//            .withOutputLanguage(Language.ZH)
//            .withPathsGroupedBy(GroupBy.TAGS)
//            .withGeneratedExamples()
//            .withoutInlineSchema()
//            .build();
//    Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
//            .withConfig(config)
//            .build();
//    converter.toFile(outputFile);
//}
