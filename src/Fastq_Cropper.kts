import java.io.File

fun headcrop(seq: String, q_score: String, nucl_num: Int): Pair<String,String>{
    var seq_length = seq.length
    var sliced_seq = seq.slice((nucl_num..(seq_length-1)))
    var sliced_q_score = q_score.slice((nucl_num..(seq_length-1)))
    return Pair(sliced_seq, sliced_q_score)
}

fun tailcrop(seq: String, q_score: String, nucl_num: Int): Pair<String,String>{
    var seq_length = seq.length
    var sliced_seq = seq.slice((0..((seq_length-1) - nucl_num)))
    var sliced_q_score = q_score.slice((0..((seq_length-1) - nucl_num)))
    return Pair(sliced_seq, sliced_q_score)
}

fun main(args: Array<String>) {
    val file_name: String = args[0]
    val file_iterator = File(file_name).readLines().iterator()

    file_iterator.forEach {
        var name = it
        var fastq_seq = file_iterator.next()
        file_iterator.next()
        var quality = file_iterator.next()

        if (args.contains("--headcrop")) {
            var headcrop_res =  headcrop(fastq_seq, quality, args[2].toInt())
            fastq_seq = headcrop_res.first
            quality = headcrop_res.second

            var new_file_name = args[1]
            var new_file = File(new_file_name)
            new_file.appendText(name + "\n")
            new_file.appendText(fastq_seq + "\n")
            new_file.appendText("+" + "\n")
            new_file.appendText(quality + "\n")
        }

        if (args.contains("--tailcrop")) {
            var tailcrop_res =  tailcrop(fastq_seq, quality, args[2].toInt())
            fastq_seq = tailcrop_res.first
            quality = tailcrop_res.second

            var new_file_name = args[1]
            var new_file = File(new_file_name)
            new_file.appendText(name + "\n")
            new_file.appendText(fastq_seq + "\n")
            new_file.appendText("+" + "\n")
            new_file.appendText(quality + "\n")
        }
    }
}

main(args)
