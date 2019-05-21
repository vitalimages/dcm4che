    usage: wadors [options] [URLs...]
    
    Wado RS client simulator. It supports retrieving Study, Series, Instance
    and Metadata. One may choose to specify multiple urls as arguments. Each
    of the objects of the Study/series shall be saved to the current working
    directory or the directory selected by user as <uid>-001.dicom,
    <uid>-002.dicom and so on. The uid is determined based on the url(s)
    specified. For eg. if study is retrieved the Study IUID will be used, if
    the url is for series retrieval then Series IUID shall be used. The
    extension of individual parts is determined by accept header.
    -
    Options:
     -a,--accept <arg>           Specify the value for Accept header.
                                 Supported types for object retrieval are
                                 dicom, octetstream, pdf, jpeg, jp2, jpx,
                                 xjls, xdicomrle, mpeg and mp4. To retrieve
                                 metadata, supported types are xml or json. If
                                 no value is specified, then wildcard shall be
                                 sent in the request. The appropriate value of
                                 Accept shall be sent in request header or as
                                 a query parameter. For eg. if it is jpeg then
                                 Accept value shall be
                                 multipart/related;type=image/jpeg.
     -h,--help                   display this help and exit
        --header                 If specified, Accept value shall be sent as
                                 header, else it shall be appended to the URL
                                 as a query parameter.
        --out-dir <directory>    Specify directory where the received MIME
                                 multipart messages will be unpacked into
                                 different parts.
     -u,--user <user:password>   Specify the user name and password to use for
                                 server authentication.
     -V,--version                output version information and exit
    
    Examples:
    => wadors
    http[s]://<host>:<port>/dcm4chee-arc/aets/{AETitle}/rs/studies/{StudyIUID1
    }
    Send WADO RS request to Wado RS Receiver to retrieve studies with Study
    Instance UID StudyIUID1
    
    => wadors
    http[s]://<host>:<port>/dcm4chee-arc/aets/{AETitle}/rs/studies/{StudyIUID1
    }
    http[s]://<host>:<port>/dcm4chee-arc/aets/{AETitle}/rs/studies/{StudyIUID2
    }/series/{SeriesIUID21}
    Send WADO RS request to Wado RS Receiver to retrieve studies with Study
    Instance UID StudyIUID1 and to retrieve series of study with Study
    Instance UID StudyIUID2 and series instance UID as SeriesIUID21.