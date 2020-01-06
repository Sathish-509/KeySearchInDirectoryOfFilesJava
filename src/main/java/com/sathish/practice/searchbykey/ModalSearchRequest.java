package com.sathish.practice.searchbykey;

import java.io.Serializable;

public class ModalSearchRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String directoryPath;
    private String searchKey;

    public ModalSearchRequest() {

    }

    public ModalSearchRequest(String directoryPath, String searchKey){
        this.directoryPath = directoryPath;
        this.searchKey = searchKey;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    private static class ModalSearchRequestBuilder {
        private String directoryPath;
        private String searchKey;

        public ModalSearchRequestBuilder setDirectoryPath(String directoryPath) {
            this.directoryPath = directoryPath;
            return this;
        }

        public ModalSearchRequestBuilder setSearchKey(String searchKey) {
            this.searchKey = searchKey;
            return this;
        }

        public ModalSearchRequest build() {
            return new ModalSearchRequest(directoryPath, searchKey);
        }
    }
    public static ModalSearchRequestBuilder newBuilder() {
        return new ModalSearchRequestBuilder();
    }
}
