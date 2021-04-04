package reivosar.common.domain.model.type;

public abstract class StringValueObject extends TypeValueObject<String>
{
    public StringValueObject(String value) {
        super(value);
    }

    public StringValueObject(StringValueObject value) {
        super(value);
    }
}
