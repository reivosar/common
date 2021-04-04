package reivosar.common.util.communication.response;

public class ResponseStatus {
    private enum TYPE {
        SUCCESS() {
            @Override
            boolean hasError() {
                return false;
            }
        },
        CLIENT_ERROR,
        SERVER_ERROR,
        UNKNOWN_ERROR,
        ;
        boolean hasError() {
            return true;
        };
    }

    public static final ResponseStatus SUCCESS = new ResponseStatus(TYPE.SUCCESS);
    public static final ResponseStatus CLIENT_ERROR = new ResponseStatus(TYPE.CLIENT_ERROR);
    public static final ResponseStatus SERVER_ERROR = new ResponseStatus(TYPE.SERVER_ERROR);
    public static final ResponseStatus UNKNOWN_ERROR = new ResponseStatus(TYPE.UNKNOWN_ERROR);

    private final TYPE type;

    private ResponseStatus(TYPE type) {
        this.type = type;
    }

    public boolean isSuccess() {
        return !hasError();
    }

    public boolean hasError() {
        return type.hasError();
    }
}
