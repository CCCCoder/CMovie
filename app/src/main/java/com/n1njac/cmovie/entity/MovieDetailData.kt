package com.n1njac.cmovie.entity

data class MovieDetailData(
    var advertisement: Advertisement,
    var basic: Basic,
    var boxOffice: BoxOffice,
    var live: Live,
    var playState: String,
    var playlist: List<Any>,
    var related: Related
) {
    data class Related(
        var goodsCount: Int,
        var goodsList: List<Any>,
        var relateId: Int,
        var relatedUrl: String,
        var type: Int
    )

    data class Live(
        var count: Int,
        var img: String,
        var liveId: Int,
        var playNumTag: String,
        var playTag: String,
        var status: Int,
        var title: String
    )

    class BoxOffice(
    )

    data class Advertisement(
        var advList: List<Adv>,
        var count: Int,
        var error: String,
        var success: Boolean
    ) {
        data class Adv(
            var advTag: String,
            var endDate: Int,
            var isHorizontalScreen: Boolean,
            var isOpenH5: Boolean,
            var startDate: Int,
            var tag: String,
            var type: String,
            var typeName: String,
            var url: String
        )
    }

    data class Basic(
        var actors: List<Actor>,
        var award: Award,
        var bigImage: String,
        var commentSpecial: String,
        var community: Community,
        var director: Director,
        var festivals: List<Festival>,
        var hotRanking: Int,
        var img: String,
        var is3D: Boolean,
        var isDMAX: Boolean,
        var isEggHunt: Boolean,
        var isFilter: Boolean,
        var isIMAX: Boolean,
        var isIMAX3D: Boolean,
        var isTicket: Boolean,
        var message: String,
        var mins: String,
        var movieId: Int,
        var movieStatus: Int,
        var name: String,
        var nameEn: String,
        var overallRating: Double,
        var personCount: Int,
        var quizGame: QuizGame,
        var releaseArea: String,
        var releaseDate: String,
        var sensitiveStatus: Boolean,
        var showCinemaCount: Int,
        var showDay: Int,
        var showtimeCount: Int,
        var stageImg: StageImg,
        var story: String,
        var style: Style,
        var totalNominateAward: Int,
        var totalWinAward: Int,
        var type: List<String>,
        var url: String,
        var video: Video
    ) {
        data class Festival(
            var festivalId: Int,
            var img: String,
            var nameCn: String,
            var nameEn: String,
            var shortName: String
        )

        class QuizGame(
        )

        class Community(
        )

        data class Director(
            var directorId: Int,
            var img: String,
            var name: String,
            var nameEn: String
        )

        data class Video(
            var count: Int,
            var hightUrl: String,
            var img: String,
            var title: String,
            var url: String,
            var videoId: Int,
            var videoSourceType: Int
        )

        data class Actor(
            var actorId: Int,
            var img: String,
            var name: String,
            var nameEn: String,
            var roleImg: String,
            var roleName: String
        )

        data class Style(
            var isLeadPage: Int,
            var leadImg: String,
            var leadUrl: String
        )

        data class StageImg(
            var count: Int,
            var list: List<X>
        ) {
            data class X(
                var imgId: Int,
                var imgUrl: String
            )
        }

        data class Award(
            var awardList: List<Award>,
            var totalNominateAward: Int,
            var totalWinAward: Int
        ) {
            data class Award(
                var festivalId: Int,
                var nominateAwards: List<NominateAward>,
                var nominateCount: Int,
                var winAwards: List<Any>,
                var winCount: Int
            ) {
                data class NominateAward(
                    var awardName: String,
                    var festivalEventYear: String,
                    var persons: List<Person>,
                    var sequenceNumber: Int
                ) {
                    data class Person(
                        var nameCn: String,
                        var nameEn: String,
                        var personId: Int
                    )
                }
            }
        }
    }
}