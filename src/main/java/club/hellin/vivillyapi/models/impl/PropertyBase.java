package club.hellin.vivillyapi.models.impl;

public interface PropertyBase {
    int getId();
    String getAssociate();
    PropertyBase setAssociate(final String associate);
    String getK();
    default String getKey() {
        return this.getK();
    }
    PropertyBase setK(final String k);
    String getValue();
    PropertyBase setValue(final String value);
}