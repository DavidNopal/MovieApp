package com.example.learnnavigation

import android.R.attr.id
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel(){
    val movies = listOf(
        Movie(1, "Spider-Man: Homecoming", R.drawable.spidermanhomecoming, "After his thrilling debut alongside the Avengers, young Peter Parker struggles to balance high school life with his secret identity as Spider-Man. Eager to prove himself as more than just a friendly neighborhood hero, he sets out to stop a dangerous new villain — the Vulture — who threatens New York City with advanced stolen technology. As Peter juggles classes, crushes, and crime-fighting, he learns that true heroism comes from responsibility, not recognition. With Tony Stark as his reluctant mentor, Peter discovers that growing up can be just as challenging as saving the world."),
        Movie(2, "Guardians of the Galaxy", R.drawable.gotgposter, "Brash space adventurer Peter Quill (Chris Pratt) finds himself the quarry of relentless bounty hunters after he steals an orb coveted by Ronan, a powerful villain. To evade Ronan, Quill is forced into an uneasy truce with four disparate misfits: gun-toting Rocket Raccoon, treelike-humanoid Groot, enigmatic Gamora, and vengeance-driven Drax the Destroyer. But when he discovers the orb's true power and the cosmic threat it poses, Quill must rally his ragtag group to save the universe."),
        Movie(3, "The Fall Guy",R.drawable.fallguyposter, "Colt Seavers, a down-on-his-luck stuntman, is pulled back into the world of action movies when a major star mysteriously disappears from a film set. What starts as a routine job quickly spirals into a wild mix of explosions, chases, and unexpected danger. As Colt digs deeper, he finds himself caught in a real-life thriller that’s far riskier than any stunt he’s ever pulled. With his courage, quick thinking, and a few bruises along the way, he proves that heroes don’t always wear capes—sometimes, they fall for a living."),
        Movie(4, "Avengers: Infinity War", R.drawable.infinitywar, "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment."),
        Movie(5, "Gladiator", R.drawable.gladiatorposter, "Set in Roman times, the story of a once-powerful general forced to become a common gladiator. The emperor's son is enraged when he is passed over as heir in favour of his father's favourite general. He kills his father and arranges the murder of the general's family, and the general is sold into slavery to be trained as a gladiator - but his subsequent popularity in the arena threatens the throne."),
        Movie(6, "John Wick: Chapter 4", R.drawable.jw4poster, "With the price on his head ever increasing, legendary hit man John Wick takes his fight against the High Table global as he seeks out the most powerful players in the underworld, from New York to Paris to Japan to Berlin."),
        Movie(7, "Tron", R.drawable.tron_poster, "When talented computer engineer Kevin Flynn (Jeff Bridges) finds out that Ed Dillinger (David Warner), an executive at his company, has been stealing his work, he tries to hack into the system. However, Flynn is transported into the digital world, where he has to face off against Dillinger's computerized likeness, Sark, and the imposing Master Control Program. Aided by Tron (Bruce Boxleitner) and Yori (Cindy Morgan), Flynn becomes a freedom fighter for the oppressed programs of the grid."),
        Movie(8, "How To Train Your Dragon", R.drawable.httyd, "Set in a Viking village plagued by dragon attacks, a young misfit named Hiccup dreams of proving himself as a true warrior. When he captures a rare dragon, he realizes the creatures aren’t the mindless beasts everyone believes. Forming an unlikely friendship with the injured Night Fury he names Toothless, Hiccup discovers a new way for humans and dragons to live in peace. As danger looms, he must challenge tradition and show his village that understanding can be more powerful than fear."),
        Movie(9, "The Lion King", R.drawable.lionking, "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).")
    )

    private val _watchlist = mutableStateListOf<Movie>()
    val watchlist: SnapshotStateList<Movie> = _watchlist

    fun addToWatchlist(movie: Movie) {
        if (!_watchlist.contains(movie)) {
            _watchlist.add(movie)
        }
    }

    fun removeFromWatchlist(movie: Movie) {
        _watchlist.remove(movie)
    }
}