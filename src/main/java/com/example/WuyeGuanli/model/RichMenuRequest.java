package com.example.WuyeGuanli.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RichMenuRequest {
    private Size size;
    private boolean selected;
    private String name;
    private String chatBarText;
    private List<Area> areas;

    @Data
    @Builder
    public static class Size {
        private int width;
        private int height;
    }

    @Data
    @Builder
    public static class Area {
        private Bounds bounds;
        private Action action;
    }

    @Data
    @Builder
    public static class Bounds {
        private int x;
        private int y;
        private int width;
        private int height;
    }

    @Data
    @Builder
    public static class Action {
        private String type;
        private String text;
    }
}
