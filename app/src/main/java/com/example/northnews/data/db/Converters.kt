package com.example.northnews.data.db

import androidx.room.TypeConverter
import com.example.northnews.data.api.response.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}