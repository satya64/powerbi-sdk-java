package io.github.satya64.powerbi.api.model;

public enum FileFormat {
    CSV, /* Requested file format is CSV (only supported for paginated reports) */
    DOCX, /* Requested file format is DOCX (only supported for paginated reports) */
    IMAGE, /* Requested file format is IMAGE (only supported for paginated reports) */
    MHTML, /* Requested file format is MHTML (only supported for paginated reports) */
    PDF, /* Requested file format is PDF */
    PNG, /* Requested file format is PNG (only supported for Power BI reports) */
    PPTX, /* Requested file format is PPTX */
    XLSX, /* Requested file format is XLSX (only supported for paginated reports) */
    XML, /* Requested file format is XML (only supported for paginated reports) */
}
