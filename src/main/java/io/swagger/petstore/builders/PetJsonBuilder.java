package io.swagger.petstore.builders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.petstore.api.core.ApiParams;

public class PetJsonBuilder {

    private final ObjectNode petDetails = new ObjectMapper().createObjectNode();
    private final ObjectNode categoryDetails = new ObjectMapper().createObjectNode();
    private final ObjectNode tagDetails = new ObjectMapper().createObjectNode();
    private final ArrayNode arrayNodePhotos = new ObjectMapper().createArrayNode();
    private final ArrayNode arrayNodeTags = new ObjectMapper().createArrayNode();

    public PetJsonBuilder addPetId(Long id) {
        petDetails.put(ApiParams.ID, id);
        return this;
    }

    public PetJsonBuilder addCategory(Integer id, String name) {
        categoryDetails.put(ApiParams.ID, id);
        categoryDetails.put(ApiParams.NAME, name);
        petDetails.set(ApiParams.CATEGORY, categoryDetails);
        return this;
    }

    public PetJsonBuilder addPetName(String petName) {
        petDetails.put(ApiParams.NAME, petName);
        return this;
    }

    public PetJsonBuilder addPhotoUrls(String url) {
        arrayNodePhotos.add(url);
        petDetails.set(ApiParams.PHOTO_URLS, arrayNodePhotos);
        return this;
    }

    public PetJsonBuilder addTags(Integer id, String name) {
        tagDetails.put(ApiParams.ID, id);
        tagDetails.put(ApiParams.NAME, name);
        arrayNodeTags.add(tagDetails);
        petDetails.set(ApiParams.TAGS, arrayNodeTags);
        return this;
    }

    public PetJsonBuilder addStatus(String status) {
        petDetails.put(ApiParams.STATUS, status);
        return this;
    }

    public String build() {
        ObjectMapper objMapper = new ObjectMapper();
        try {
            return objMapper.writeValueAsString(petDetails);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
