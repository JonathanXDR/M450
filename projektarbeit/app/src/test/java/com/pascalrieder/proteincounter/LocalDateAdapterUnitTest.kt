package com.pascalrieder.proteincounter

import com.google.gson.JsonPrimitive
import com.pascalrieder.proteincounter.data.LocalDateAdapter
import org.junit.Test
import java.time.LocalDate

class LocalDateAdapterUnitTest {
    private val localDateAdapter = LocalDateAdapter()

    @Test
    fun `serialization is correct`() {
        val date = localDateAdapter.serialize(LocalDate.of(2000, 1, 1), null, null)
        assert(date.asString == "2000-01-01")
    }

    @Test
    fun `deserialization is correct`() {
        val date = localDateAdapter.deserialize(JsonPrimitive("2000-01-01"), null, null)
        assert(date == LocalDate.of(2000, 1, 1))
    }
}