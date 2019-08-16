package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics =  new ArrayList<> (Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework description"),
			new Topic("Java", "Core Java", "Java Framework description"),
			new Topic("Phython", "Phyton Framework", "Python Framework description")
			));
	
	public List <Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
				
	}

	public void deleteTopic(String id) {
		 //topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
