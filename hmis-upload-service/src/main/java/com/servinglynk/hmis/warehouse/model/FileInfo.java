package com.servinglynk.hmis.warehouse.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileInfo   {
  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileSize")
  private Integer fileSize = null;

  public FileInfo fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

   /**
   * The file URL.
   * @return fileName
  **/
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public FileInfo fileSize(Integer fileSize) {
    this.fileSize = fileSize;
    return this;
  }

   /**
   * The file size.
   * @return fileSize
  **/
  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileInfo user = (FileInfo) o;
    return Objects.equals(this.fileName, user.fileName) &&
        Objects.equals(this.fileSize, user.fileSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, fileSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

