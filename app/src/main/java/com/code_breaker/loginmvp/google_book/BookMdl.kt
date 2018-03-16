package com.code_breaker.loginmvp.google_book

/**
 * Created by akira on 16/03/18.
 */

class BookMdl {

//    data class BookDataMdl(var isbn: String)

    var kind: String? = null
    var totalItems: Int = 0
    var items: List<ItemsBean>? = null

    class ItemsBean {
        var kind: String? = null
        var id: String? = null
        var etag: String? = null
        var selfLink: String? = null
        var volumeInfo: VolumeInfoBean? = null
        var saleInfo: SaleInfoBean? = null
        var accessInfo: AccessInfoBean? = null
        var searchInfo: SearchInfoBean? = null

        class VolumeInfoBean {
            var title: String? = null
            var publisher: String? = null
            var publishedDate: String? = null
            var description: String? = null
            var readingModes: ReadingModesBean? = null
            var pageCount: Int = 0
            var printType: String? = null
            var averageRating: Double = 0.toDouble()
            var ratingsCount: Int = 0
            var maturityRating: String? = null
            var isAllowAnonLogging: Boolean = false
            var contentVersion: String? = null
            var imageLinks: ImageLinksBean? = null
            var language: String? = null
            var previewLink: String? = null
            var infoLink: String? = null
            var canonicalVolumeLink: String? = null
            var authors: List<String>? = null
            var industryIdentifiers: List<IndustryIdentifiersBean>? = null
            var categories: List<String>? = null

            class ReadingModesBean {
                var isText: Boolean = false
                var isImage: Boolean = false
            }

            class ImageLinksBean {
                var smallThumbnail: String? = null
                var thumbnail: String? = null
            }

            class IndustryIdentifiersBean {
                var type: String? = null
                var identifier: String? = null
            }
        }

        class SaleInfoBean {
            var country: String? = null
            var saleability: String? = null
            var isIsEbook: Boolean = false
        }

        class AccessInfoBean {
            var country: String? = null
            var viewability: String? = null
            var isEmbeddable: Boolean = false
            var isPublicDomain: Boolean = false
            var textToSpeechPermission: String? = null
            var epub: EpubBean? = null
            var pdf: PdfBean? = null
            var webReaderLink: String? = null
            var accessViewStatus: String? = null
            var isQuoteSharingAllowed: Boolean = false

            class EpubBean {
                var isIsAvailable: Boolean = false
            }

            class PdfBean {
                var isIsAvailable: Boolean = false
            }
        }

        class SearchInfoBean {
            var textSnippet: String? = null
        }
    }
}
