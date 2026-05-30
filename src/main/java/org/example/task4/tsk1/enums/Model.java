package org.example.task4.tsk1.enums;

public enum Model {
    A4(Producer.AUDI),
    Q7(Producer.AUDI),
    CAMRY(Producer.TOYOTA),
    SWIFT(Producer.SUZUKI),
    CX50(Producer.MAZDA),
    EV3(Producer.KIA);
    private final Producer producer;

    Model(Producer producer) {
        this.producer = producer;
    }
    public Producer getProducer() {
        return producer;
    }
}
