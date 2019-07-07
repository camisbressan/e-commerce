package br.com.fiap.test;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.entity.Produto;

public class ClientUtil {
	public void getProdutoByIdDemo(long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/produto/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Produto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Produto.class, id);
		Produto produto = responseEntity.getBody();
		System.out.println(produto);
	}

	public void getAllProdutosDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/produtos";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Produto[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Produto[].class);
		Produto[] produtos = responseEntity.getBody();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	public void addProdutoDemo(Produto objProduto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/produto";
		HttpEntity<Produto> requestEntity = new HttpEntity<Produto>(objProduto, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updateProdutoDemo(Produto objProduto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/produto";
		HttpEntity<Produto> requestEntity = new HttpEntity<Produto>(objProduto, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deleteProdutoDemo(long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/spring-app/estoque/produto/{id}";
		HttpEntity<Produto> requestEntity = new HttpEntity<Produto>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);
	}

	public static void main(String args[]) {
		ClientUtil util = new ClientUtil();

		util.addProdutoDemo(new Produto("007 Golden Eye Reloaded", 54, 152.90));
		util.addProdutoDemo(new Produto("007 James Bond - Blood Stone", 82, 114.90));

		util.addProdutoDemo(new Produto("007 Legends", 40, 171.90));

		util.addProdutoDemo(new Produto("007 Quantum of Solace", 76, 192.90));

		util.addProdutoDemo(new Produto("11 Eyes - Cross Over (JPN)", 90, 134.90));

		util.addProdutoDemo(new Produto("50 Cent: Blood on the Sands", 77, 140.90));

		util.addProdutoDemo(new Produto("A-Train HX", 43, 187.90));

		util.addProdutoDemo(new Produto("A grande aventura de Snoopy", 61, 171.90));

		util.addProdutoDemo(new Produto("Absolute - Blazing Infinity (JPN)", 26, 176.90));

		util.addProdutoDemo(new Produto("Ace Combat - Assault Horizon", 30, 117.90));

		util.addProdutoDemo(new Produto("Ace Combat 6 - Fires of Liberation", 56, 118.90));

		util.addProdutoDemo(new Produto("Adidas MiCoach (2 DVDs) (Kinect)", 36, 155.90));

		util.addProdutoDemo(new Produto("Adrenalin Misfits (Kinect)", 74, 196.90));

		util.addProdutoDemo(
				new Produto("Adventure Time - As investigações de Finn e Jake (Hora de Aventura)", 14, 125.90));

		util.addProdutoDemo(new Produto("Adventure Time - Explore the Dungeon Because I don`t Know (Hora de Aventura)",
				30, 166.90));

		util.addProdutoDemo(
				new Produto("Adventure Time - The Secret of the Nameless Kingdom (Hora de Aventura)", 76, 169.90));

		util.addProdutoDemo(new Produto("AFL Live", 67, 124.90));

		util.addProdutoDemo(new Produto("AFL Live 2", 31, 147.90));

		util.addProdutoDemo(new Produto("Afro Samurai", 16, 173.90));

		util.addProdutoDemo(new Produto("Air Conflicts: Pacific Carrier", 55, 176.90));

		util.addProdutoDemo(new Produto("Air Conflicts: Secret Wars", 31, 173.90));

		util.addProdutoDemo(new Produto("Air Conflicts: Vietnam", 64, 181.90));

		util.addProdutoDemo(new Produto("Akai Katana", 66, 192.90));

		util.addProdutoDemo(new Produto("Akatsuki-no Amaneka to Aoi Kyojin", 74, 162.90));

		util.addProdutoDemo(new Produto("Alan Wake", 99, 173.90));

		util.addProdutoDemo(new Produto("Alarm für Cobra 11 - Burning Wheels", 76, 154.90));

		util.addProdutoDemo(new Produto("Alarm für Cobra 11 - Crash Time", 48, 124.90));

		util.addProdutoDemo(new Produto("Alarm für Cobra 11 - Highway Nights", 33, 177.90));

		util.addProdutoDemo(new Produto("Alice: Madness Returns", 41, 198.90));

		util.addProdutoDemo(new Produto("Alien Isolation (Dublado)", 57, 138.90));

		util.addProdutoDemo(new Produto("Alien Vs Predator", 72, 198.90));

		util.addProdutoDemo(new Produto("Aliens: Colonial Marines", 22, 199.90));

		util.addProdutoDemo(new Produto("All-Pro Football 2K8", 53, 146.90));

		util.addProdutoDemo(new Produto("Alone in the Dark", 66, 110.90));

		util.addProdutoDemo(new Produto("Alpha Protocol", 58, 112.90));

		util.addProdutoDemo(new Produto("Alvin and the Chipmunks – Chipwrecked (Kinect)", 98, 128.90));

		util.addProdutoDemo(new Produto("Americas Army - True Soldiers", 31, 103.90));

		util.addProdutoDemo(new Produto("Amped 3", 90, 103.90));

		util.addProdutoDemo(new Produto("Anarchy Reigns (Max Anarchy)", 69, 179.90));

		util.addProdutoDemo(new Produto("Angry Birds Star Wars (Controle ou Kinect)", 40, 161.90));

		util.addProdutoDemo(new Produto("Angry Birds Trilogy (Controle ou Kinect)", 54, 198.90));

		util.addProdutoDemo(new Produto("Apache: Air Assault", 45, 154.90));

		util.addProdutoDemo(new Produto("AquaZone - Life Simulator", 94, 173.90));

		util.addProdutoDemo(new Produto("Arcana Heart 3", 41, 178.90));

		util.addProdutoDemo(new Produto("Arcania - The Complete Tale", 61, 107.90));

		util.addProdutoDemo(new Produto("Armored Core - For Answer", 82, 161.90));

		util.addProdutoDemo(new Produto("Armored Core 4", 55, 176.90));

		util.addProdutoDemo(new Produto("Armored Core V", 93, 187.90));

		util.addProdutoDemo(new Produto("Armored Core Verdict Day", 58, 187.90));

		util.addProdutoDemo(new Produto("Army of Two", 55, 101.90));

		util.addProdutoDemo(new Produto("Army of Two The 40th Day", 41, 166.90));

		util.addProdutoDemo(new Produto("Army of Two: Devil`s Cartel", 79, 179.90));

		util.addProdutoDemo(new Produto("As Aventuras de Tintin", 54, 158.90));

		util.addProdutoDemo(new Produto("Ashes Cricket 2009", 20, 151.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed", 24, 107.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed II", 74, 176.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed III (Dublado)", 12, 110.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed 4 Black Flag (Dublado) (2 DVDs)", 47, 136.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed Brotherhood", 22, 128.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed Revelations", 21, 182.90));

		util.addProdutoDemo(new Produto("Assassin`s Creed Rogue (Dublado)", 35, 195.90));

		util.addProdutoDemo(new Produto("Asterix at the Olympic Games", 13, 130.90));

		util.addProdutoDemo(new Produto("Asura’s Wrath", 62, 164.90));

		util.addProdutoDemo(new Produto("Attack of the Movie 3D", 37, 128.90));

		util.addProdutoDemo(new Produto("Autobahn Polizei", 33, 147.90));

		util.addProdutoDemo(new Produto("Avatar - The Last Airbender - The Burning Earth", 50, 102.90));

		util.addProdutoDemo(new Produto("Avatar The Game", 46, 102.90));

		util.addProdutoDemo(
				new Produto("Back to the Future: The Game 30th Anniversary Ed. (De volta para o Futuro)", 91, 137.90));

		util.addProdutoDemo(new Produto("Backyard Football `10", 77, 147.90));

		util.addProdutoDemo(new Produto("Backyard Sports - Rookie Rush", 20, 120.90));

		util.addProdutoDemo(new Produto("Backyard Sports - Sandlot Sluggers", 43, 114.90));

		util.addProdutoDemo(new Produto("Baja - Edge of Control", 47, 152.90));

		util.addProdutoDemo(new Produto("Bakugan - Battle Brawlers", 96, 114.90));

		util.addProdutoDemo(new Produto("Bakugan - Defender of the Core", 81, 140.90));

		util.addProdutoDemo(new Produto("BandFuse - Rock Legends (Precisa de controle especial)", 61, 134.90));

		util.addProdutoDemo(new Produto("Banjo-Kazooie - Nuts & Bolts", 15, 110.90));

		util.addProdutoDemo(new Produto("Barbie e suas irmãs - Resgate de Cachorrinhos", 94, 173.90));

		util.addProdutoDemo(new Produto("Bass Pro Shops - The Hunt", 44, 180.90));

		util.addProdutoDemo(new Produto("Bass Pro Shops - The Strike", 70, 190.90));

		util.addProdutoDemo(new Produto("Batman: Arkham Asilum", 23, 152.90));

		util.addProdutoDemo(new Produto("Batman: Arkham City", 47, 127.90));

		util.addProdutoDemo(new Produto("Batman: Arkham Origins (Dublado)", 39, 130.90));

		util.addProdutoDemo(new Produto("Battle Fantasia", 88, 126.90));

		util.addProdutoDemo(new Produto("Battle vs Chess", 35, 119.90));

		util.addProdutoDemo(new Produto("Battlefield - Bad Company", 65, 107.90));

		util.addProdutoDemo(new Produto("Battlefield - Bad Company 2", 60, 153.90));

		util.addProdutoDemo(new Produto("Battlefield 2 - Modern Combat", 61, 143.90));

		util.addProdutoDemo(new Produto("Battlefield 3", 61, 144.90));

		util.addProdutoDemo(new Produto("Battlefield 4 (Dublado)", 92, 131.90));

		util.addProdutoDemo(new Produto("Battlefield Hardline (Dublado) (10,8GB)", 10, 164.90));

		util.addProdutoDemo(new Produto("Battleship", 97, 188.90));

		util.addProdutoDemo(new Produto("Battlestations - Midway", 16, 137.90));

		util.addProdutoDemo(new Produto("Battlestations - Pacific", 58, 179.90));

		util.addProdutoDemo(new Produto("Bayonetta", 79, 181.90));

		util.addProdutoDemo(new Produto("Beautiful Katamari", 22, 188.90));

		util.addProdutoDemo(new Produto("Bee Movie Game (A História de uma Abelha)", 38, 186.90));

		util.addProdutoDemo(new Produto("Beijing 2008 - The Official Video Game of the Olympic Games", 17, 125.90));

		util.addProdutoDemo(new Produto("Ben 10 - Alien Force - Vilgax Attacks", 29, 135.90));

		util.addProdutoDemo(new Produto("Ben 10 - Galactic Racing", 68, 146.90));

		util.addProdutoDemo(new Produto("Ben 10 - Omniverse", 35, 119.90));

		// objProduto.nome = "Laranja";
		// util.updateProdutoDemo(objProduto);

		// util.deleteProdutoDemo(1);
		// util.getProdutoByIdDemo(1);

		// util.getAllProdutosDemo();
	}
}
