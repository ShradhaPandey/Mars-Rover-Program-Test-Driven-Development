package com.rover.space;

public enum DirectionOfMotion {

    N(0,1) {
        @Override
        public DirectionOfMotion left() {
            return W;
        }

        @Override
        public DirectionOfMotion right() {
            return E;
        }
    },

    S(0,-1) {
        @Override
        public DirectionOfMotion right() {
            return W;
        }

        @Override
        public DirectionOfMotion left() {
            return E;
        }
    },

    E(1,0) {
        @Override
        public DirectionOfMotion right() {
            return S;
        }

        @Override
        public DirectionOfMotion left() {
            return N;
        }
    },

    W(-1,0) {
        @Override
        public DirectionOfMotion right() {
            return N;
        }

        @Override
        public DirectionOfMotion left() {
            return S;
        }
    };

    private final int stepSizeOnXAxis;
    private final int stepSizeOnYAxis;

    DirectionOfMotion(final int stepSizeOnXAxis, final int stepSizeOnYAxis) {
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public abstract DirectionOfMotion right();
    public abstract DirectionOfMotion left();

    public int stepSizeForXAxis() {
        return this.stepSizeOnXAxis;
    }

    public int stepSizeForYAxis() {
        return this.stepSizeOnYAxis;
    }

}
