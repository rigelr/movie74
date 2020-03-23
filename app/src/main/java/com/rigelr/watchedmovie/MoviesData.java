package com.rigelr.watchedmovie;

import com.rigelr.watchedmovie.models.Movie;

import java.util.ArrayList;

public class MoviesData {

    private static String[] movieNames = {
            "Bucin",
            "I Still Believe",
            "Jexi",
            "Malik & Elsa",
            "Tarung Sarung",
            "The Cave",
            "Trolls World Tour",
            "Walking Dead Tomate"
    };
    private static int[] movieImages = {
            R.drawable.bucin,
            R.drawable.istill,
            R.drawable.jexi,
            R.drawable.malik,
            R.drawable.tarung,
            R.drawable.thecave,
            R.drawable.trolls,
            R.drawable.walking
    };

    private static String[] movieDetails = {
            "Film Bucin bercerita tentang 4 sahabat (Andovi, Tommy, Jovi, dan Chandra) yang berusaha keluar dari hubungan yang tidak sehat karena mereka BUCIN (Budak Cinta). Mereka memutuskan untuk mengikuti kelas ANTI BUCIN agar mereka bisa menjalankan hubungan yang lebih dewasa, dan tidak diperbudak oleh cinta.",
            "Diangkat dari kisah nyata bintang musik rohani Jeremy Camp dan perjalanannya tentang cinta, kehilangan dan bukti bahwa selalu ada harapan bagi siapa saja yang percaya.",
            "Phil (Adam Devine) memiliki ketergantungan besar dengan ponselnya. Karena hal ini, ia tidak memiliki teman dan pacar. Saat harus mengganti ponsel pintarnya dengan model terbaru yang canggih dan punya fitur asisten virtual (Jexi), hidupnya kini lebih baik. Namun kecerdasan tinggi Jexi perlahan membuat hidup Phil menjadi mimpi buruk.",
            "Diadaptasi dari novel karya BOY CHANDRA.Kadang kedekatan bisa berawal dari sebuah perkenalan yang tidak biasa. Contohnya, seperti Malik (Endi Arfian) dan Elsa (Salshabilla Adriani).",
            "DENI RUSO (Panji Zoni) terlahir dari salah satu keluarga terkaya di Indonesia. Bagi Deni uang adalah segalanya, ia bahkan kehilangan kepercayaan terhadap Tuhan. Semuanya berubah ketika ia ke Makassar mengurus bisnis keluarga, dan bertemu TENRI (Maizura) gadis Makassar aktivis yang membenci RUSO CORP sebagai kapitalis perusak lingkungan. Deni pun menyembunyikan identitas demi mendapatkan cinta Tenri.",
            "Diangkat dari kejadian nyata, tentang Tim sepak bola remaja Thailand yang terjebak di sebuah goa. Penyelamatan dramatis yang mendapat perhatian luas masyarakat dunia dan melibatkan para ahli mancanegara.",
            "Petualangan Poppy (Anna Kendrick) dan Branch (Justin Timberlake) berlanjut. Kali ini mereka menemukan bahwa ada enam suku troll berbeda yang tersebar di enam negeri berbeda.",
            "Saat Tenri, dan Rudi liputan ke desa Panggala ( toraja), Rudi menemukan sebuah benda berupa kalung disebuah tanah yang menyerupai sisa bangunan yang telah hancur. Kejadian demi kejadian seram terus berlangsung, Rudi mencoba untuk membuang kalung itu, tapi malah kalung itu memanjang dan mencekik leher Rudi."

    };





    static ArrayList<Movie> getListData() {
        ArrayList<Movie> list = new ArrayList<>();
        for (int position = 0; position < movieNames.length; position++) {
            Movie movie = new Movie();
            movie.setName(movieNames[position]);
            movie.setDetail(movieDetails[position]);
            movie.setPhoto(movieImages[position]);
            list.add(movie);
        }
        return list;
    }
}
